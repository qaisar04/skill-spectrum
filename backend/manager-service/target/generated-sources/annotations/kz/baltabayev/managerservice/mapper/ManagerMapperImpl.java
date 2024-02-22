package kz.baltabayev.managerservice.mapper;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import kz.baltabayev.managerservice.model.dto.ManagerRequest;
import kz.baltabayev.managerservice.model.entity.Manager;
import kz.baltabayev.managerservice.model.entity.ManagerInfo;
import kz.baltabayev.managerservice.model.types.Gender;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T10:01:46+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public Manager toEntity(ManagerRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Manager manager = new Manager();

        manager.setManagerInfo( managerRequestToManagerInfo( dto ) );
        manager.setEmail( dto.getEmail() );

        return manager;
    }

    @Override
    public ManagerRequest toDto(Manager entity) {
        if ( entity == null ) {
            return null;
        }

        ManagerRequest managerRequest = new ManagerRequest();

        managerRequest.setEmail( entity.getEmail() );
        managerRequest.setFirstname( entityManagerInfoFirstname( entity ) );
        managerRequest.setLastname( entityManagerInfoLastname( entity ) );
        managerRequest.setGender( entityManagerInfoGender( entity ) );
        managerRequest.setBirthDate( entityManagerInfoBirthDate( entity ) );

        return managerRequest;
    }

    protected ManagerInfo managerRequestToManagerInfo(ManagerRequest managerRequest) {
        if ( managerRequest == null ) {
            return null;
        }

        ManagerInfo.ManagerInfoBuilder managerInfo = ManagerInfo.builder();

        managerInfo.firstname( managerRequest.getFirstname() );
        managerInfo.lastname( managerRequest.getLastname() );
        managerInfo.gender( managerRequest.getGender() );
        managerInfo.birthDate( managerRequest.getBirthDate() );

        return managerInfo.build();
    }

    private String entityManagerInfoFirstname(Manager manager) {
        if ( manager == null ) {
            return null;
        }
        ManagerInfo managerInfo = manager.getManagerInfo();
        if ( managerInfo == null ) {
            return null;
        }
        String firstname = managerInfo.getFirstname();
        if ( firstname == null ) {
            return null;
        }
        return firstname;
    }

    private String entityManagerInfoLastname(Manager manager) {
        if ( manager == null ) {
            return null;
        }
        ManagerInfo managerInfo = manager.getManagerInfo();
        if ( managerInfo == null ) {
            return null;
        }
        String lastname = managerInfo.getLastname();
        if ( lastname == null ) {
            return null;
        }
        return lastname;
    }

    private Gender entityManagerInfoGender(Manager manager) {
        if ( manager == null ) {
            return null;
        }
        ManagerInfo managerInfo = manager.getManagerInfo();
        if ( managerInfo == null ) {
            return null;
        }
        Gender gender = managerInfo.getGender();
        if ( gender == null ) {
            return null;
        }
        return gender;
    }

    private LocalDate entityManagerInfoBirthDate(Manager manager) {
        if ( manager == null ) {
            return null;
        }
        ManagerInfo managerInfo = manager.getManagerInfo();
        if ( managerInfo == null ) {
            return null;
        }
        LocalDate birthDate = managerInfo.getBirthDate();
        if ( birthDate == null ) {
            return null;
        }
        return birthDate;
    }
}
