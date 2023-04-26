package homework;

import homework.annotations.After;
import homework.annotations.Before;
import homework.annotations.Test;

public class HomeworkTest {

    @Before
    public void setUp(){

    }

    @Test
    public void DoSomeRightWorkTest(){

    }

    @Test
    public void DoSomeExceptionTest(){

        throw new RuntimeException("BOOOM!!!");
    }

    @Test
    public void DoAnyRightWorkTest(){

    }

    @After
    public void tearDown(){

    }
}
