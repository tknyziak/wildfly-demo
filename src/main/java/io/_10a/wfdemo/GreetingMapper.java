package io._10a.wfdemo;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface GreetingMapper {

    GreetingDTO fromGreeting(Greeting g);

}
