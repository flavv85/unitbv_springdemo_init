package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteMember {

    @Autowired
    Members members;

    public void delete(String id) {
        checkIfMemberExistsInDb(id);
        members.delete(id);
        log.info("Member was succsessfully removed");
    }

    public void deleteById(String memberId) {
        checkIfMemberExistsInDb(memberId);
        members.deleteMemberNativeQuery(memberId);
        log.info("Member with the %s id was succsessfully removed", memberId);
    }

    public void checkIfMemberExistsInDb(String id)
    {
        members.getMemberById(id).orElseThrow(() -> new UnknownObjectException(String.format("Member with id %s was not found", id)));
    }
}
