package com.frankmoley.lil.designpatternsapp;

import com.frankmoley.lil.designpatternsapp.prototype.ProtoFalse;
import com.frankmoley.lil.designpatternsapp.prototype.ProtoTrue;
import com.frankmoley.lil.designpatternsapp.repository.PresidentRepository;
import com.frankmoley.lil.designpatternsapp.singleton.SingA;
import com.frankmoley.lil.designpatternsapp.singleton.SingB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternsAppApplicationTests {

    @Autowired
    private SingB singB1;

    @Autowired
    private SingB singB2;

    @Autowired
    private ProtoFalse protoFalse1;
    @Autowired
    private ProtoFalse protoFalse2;

    @Autowired
    private ProtoTrue protoTrue1;


    @Autowired
    private ProtoTrue protoTrue2;


    @Autowired
    private PresidentRepository presidentRepository;


    @Test
    public void testRepository() {
        System.out.println(presidentRepository.findById(1L));
        System.out.println(presidentRepository.findById(2L));
    }


    @Test
    public void testSingletons() {
        //given
        SingA singA1 = SingA.getInstance();
        SingA singA2 = SingA.getInstance();

        //when //then
        Assertions.assertNotNull(singA1);
        Assertions.assertSame(singA1, singA2);
        Assertions.assertNotNull(singB1);
        Assertions.assertSame(singB1, singB2);
    }

    @Test
    public void protoTest() {
        Assertions.assertSame(protoFalse1, protoFalse2);
        Assertions.assertNotSame(protoTrue1, protoTrue2);
    }


}
