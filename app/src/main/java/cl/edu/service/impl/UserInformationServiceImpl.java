package cl.edu.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.edu.core.blaze.helper.BlazeHelper;
import cl.edu.core.blaze.specification.UserInformationSpecification;
import cl.edu.core.exception.custom.CustomConflictException;
import cl.edu.core.i18n.I18nConfig;
import cl.edu.dto.DeleteDto;
import cl.edu.dto.filter.UserInformationFilterRequest;
import cl.edu.dto.pagination.PageRequest;
import cl.edu.dto.pagination.PageResponse;
import cl.edu.dto.request.UserInformationRequest;
import cl.edu.dto.response.UserInformationResponse;
import cl.edu.entity.UserInformation;
import cl.edu.mapper.UserInformationMapper;
import cl.edu.repository.UserInformationRepository;
import cl.edu.service.AbstractService;
import cl.edu.service.UserInformationService;
import lombok.RequiredArgsConstructor;

@Service
@Qualifier("v1/UserInformationService")
@RequiredArgsConstructor
@Transactional
public class UserInformationServiceImpl extends AbstractService implements UserInformationService {

    private final UserInformationRepository userInformationRepository;
    private final UserInformationMapper userInformationMapper;
    private final BlazeHelper blazeHelper;
    private final I18nConfig i18nConfig;

    @Override
    public UserInformationResponse create(UserInformationRequest userInformationRequest) {
        if (userInformationRepository.existsByEmail(userInformationRequest.email())) {
            throw new CustomConflictException(i18nConfig.getMessage("error.user_information.email_exists"));
        }

        UserInformation userInformation = userInformationMapper.toEntity(userInformationRequest);
        return userInformationMapper.toResponse(userInformationRepository.save(userInformation));
    }

    @Override
    public PageResponse<UserInformationResponse> filter(PageRequest<UserInformationFilterRequest> pageRequest) {
        return this.blazeHelper.findAllPaged(
                UserInformation.class,
                pageRequest,
                UserInformationSpecification::apply,
                userInformationMapper::toResponse);
    }

    @Override
    public UserInformationResponse getById(UUID id) {
        UserInformation userInformation = findEntityById(
                userInformationRepository,
                id,
                i18nConfig.getMessage("error.user_information.not_found"));

        return userInformationMapper.toResponse(userInformation);
    }

    @Override
    public UserInformationResponse update(UUID id, UserInformationRequest userInformationRequest) {
        UserInformation userInformation = findEntityById(
                userInformationRepository,
                id,
                i18nConfig.getMessage("error.user_information.not_found"));

        if (userInformationRepository.existsByEmailAndIdNot(userInformationRequest.email(), id)) {
            throw new CustomConflictException(i18nConfig.getMessage("error.user_information.email_exists"));
        }

        userInformationMapper.updateEntityFromRequest(userInformationRequest, userInformation);

        return userInformationMapper.toResponse(userInformationRepository.save(userInformation));
    }

    @Override
    public UserInformationResponse patch(UUID id, UserInformationFilterRequest userInformationFilterRequest) {
        UserInformation userInformation = findEntityById(
                userInformationRepository,
                id,
                i18nConfig.getMessage("error.user_information.not_found"));

        UserInformationRequest userInformationRequest = userInformationMapper.toRequest(userInformationFilterRequest);

        if (userInformationFilterRequest.email() != null
                && userInformationRepository.existsByEmailAndIdNot(userInformationFilterRequest.email(), id)) {
            throw new CustomConflictException(i18nConfig.getMessage("error.user_information.email_exists"));
        }

        userInformationMapper.updateEntityFromRequest(userInformationRequest, userInformation);

        return userInformationMapper.toResponse(userInformationRepository.save(userInformation));
    }

    @Override
    public DeleteDto delete(UUID id) {
        UserInformation userInformation = findEntityById(
                userInformationRepository,
                id,
                i18nConfig.getMessage("error.user_information.not_found"));

        userInformationRepository.delete(userInformation);

        return new DeleteDto(i18nConfig.getMessage("success.user_information.deleted"));
    }

}
