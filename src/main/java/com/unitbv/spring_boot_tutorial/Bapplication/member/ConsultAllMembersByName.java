package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsultAllMembersByName {
    private static final Logger logger = LoggerFactory.getLogger(ConsultAllMembersByName.class);
    Members members;

    public List<Member> consultByName(String name) {
        logger.info("Consulting members by name: {}", name);
        List<Member> result = members.getAllMembersByName(name);
        logger.info("Found {} members", result.size());
        return result;
    }
}
