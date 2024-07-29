package com.unitbv.spring_boot_tutorial.Bapplication.Review;

import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteMembers {
    Members members;
    public void DeleteMembers() {
        members.deleteMembers();
    }
}
