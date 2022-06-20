package com.example.demo.service.member;

import com.example.demo.dto.member.MemberRequest;
import com.example.demo.dto.member.MobileRequest;
import com.example.demo.entity.member.Role;
import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(MemberRequest userRequest) {

        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        Role role = new Role(userRequest.getRole());
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = User.builder()
                .email(userRequest.getEmail())
                .password(encodedPassword)
                .name(userRequest.getName())
                .roles(roleList)
                .mobile(userRequest.getMobile())
                .profile_path("default.png")
                .build();

        //user.setPassword(encodedPassword);

        userRepository.save(user);
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        user.getRoles().add(role);

        userRepository.save(user);
    }

    @Override
    public void cellPhoneCheck(String phoneNumber, String numStr) {

        String api_key = "NCS1QRDDXPIDHH1Y";
        String api_secret = "JMVREMDWHT58DCC22NT11OILTTRMYFVY";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);
        params.put("from", "01039063340");
        params.put("type", "SMS");
        params.put("text", "인증번호는 [" + numStr + "] 입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String emailDuplicationCheck(String email) {
        String message;

        Optional<User> checkEmail = userRepository.checkEmail(email);
        if (!checkEmail.equals(Optional.empty())) {
            message = "이메일 중복입니다";

            return message;
        }
        return null;
    }

    @Override
    public String mobileDuplicationCheck(MobileRequest mobile) {

        Optional<User> checkMobile = userRepository.checkMobile(mobile.getMobile());
        if (!checkMobile.equals(Optional.empty())) {
            String message = new String("이미 인증된 전화번호입니다");

            return message;
        }

        return null;
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}