package es.consumo.junta_arbitral.modules.autonomousCommunity.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.consumo.junta_arbitral.commons.db.entity.SimpleEntity;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "autonomous_community")
@Getter
@Setter
public class AutonomousCommunityEntity extends SimpleEntity {

    public static final String SEQ_CCAA ="seq_autonomous_community";

    //genera el campo id
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CCAA)
    @SequenceGenerator(
            name = SEQ_CCAA,
            sequenceName = SEQ_CCAA,
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    //genera el campo name
    @Column(name = "NAME" )
    @NotNull(message = "Debes especificar el nombre")
    @Size(min = 1, max = 50)
    private String name;

    @JsonIgnore
    @CreatedDate
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @CreatedBy
    @Column(name = "CREATED_BY", nullable = true)
    private Long createdBy;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "UPDATED_BY", nullable = true)
    private Long updatedBy;


    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            AutonomousCommunityEntity that = (AutonomousCommunityEntity) o;
            return Objects.equals(getName(), that.getName()) && Objects.equals(name, that.name);
        }

    @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getName());
        }

        public interface SimpleProjection {

            Long getId();
            String getName();

        }
}
