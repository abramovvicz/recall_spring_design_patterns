package com.frankmoley.lil.designpatternsapp;

import com.frankmoley.lil.designpatternsapp.prototype.ProtoFalse;
import com.frankmoley.lil.designpatternsapp.prototype.ProtoTrue;
import com.frankmoley.lil.designpatternsapp.repository.PresidentRepository;
import com.frankmoley.lil.designpatternsapp.singleton.SingA;
import com.frankmoley.lil.designpatternsapp.singleton.SingB;
import org.junit.Assert;
import org.junit.Test;
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
    public void testRepository(){
        System.out.println(presidentRepository.findById(1L));
        System.out.println(presidentRepository.findById(2L));
    }


    @Test
    public void testSingletons() {
        //given
        SingA singA1 = SingA.getInstance();
        SingA singA2 = SingA.getInstance();

        //when //then
        Assert.assertNotNull(singA1);
        Assert.assertSame(singA1, singA2);
        Assert.assertNotNull(singB1);
        Assert.assertSame(singB1, singB2);
    }

    @Test
    public void protoTest(){
        Assert.assertSame(protoFalse1, protoFalse2);
        Assert.assertNotSame(protoTrue1, protoTrue2);
    }


}
