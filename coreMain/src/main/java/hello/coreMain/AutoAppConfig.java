package hello.coreMain;

import hello.coreMain.member.MemberRepository;
import hello.coreMain.member.MemoryMemberRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(
        basePackages = "hello.coreMain",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
