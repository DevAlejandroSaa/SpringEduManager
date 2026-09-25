package cl.edu.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_information")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInformation {

    @Id
    @GeneratedValue
    @UuidGenerator
    @EqualsAndHashCode.Include
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private UUID id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ToString.Exclude
    @OneToMany(mappedBy = "userInformation")
    @Builder.Default
    private Set<AccessToken> accessTokens = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "userInformation")
    @Builder.Default
    private Set<RefreshToken> refreshTokens = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "teacherUser")
    @Builder.Default
    private Set<CourseOffering> courseOfferings = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "studentUser")
    @Builder.Default
    private Set<UserCourse> userCourses = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "studentUser")
    @Builder.Default
    private Set<UserPractice> userPractices = new HashSet<>();

}
