package com.starbucks.coffee_order.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VerificationMapper {
    @Insert("insert into email_code(email, code) VALUES (#{email},#{code})")
    void putEmail(String email, String code);

    @Delete("delete from email_code where email =#{email}")
    void remove(String email);
}
