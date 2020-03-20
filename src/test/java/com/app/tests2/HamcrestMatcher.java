package com.app.tests2;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcher {
    @Test
    public void test(){
        assertThat(5,equalTo(5));

        String str1="sdet";
        String str2="sdet";

        assertThat(str1,is("sdet"));
        assertThat(str1,is(str2));
        //verify if it is not equal
        assertThat(str1,is(not("qa")));
        //verifying ingnoring case
        assertThat(str1,equalToIgnoringCase("Sdet"));
        //verifying ignoring space before and after
        assertThat(str1,equalToIgnoringWhiteSpace(" sdet"));

        //compare number
        assertThat(5,greaterThan(3));
        assertThat(7, lessThanOrEqualTo(8));

        assertThat(str1,notNullValue());

        List<String> list= Arrays.asList("key","store","order");
        assertThat(list,Matchers.<String>hasSize(3));
        //compare if the List contains in any order
        assertThat(list,containsInAnyOrder("store","order","key"));
        //verify if the list contains single item
        assertThat(list,hasItem("key"));
        //compares if multiple items exists in the list
        assertThat(list,hasItems("key","store"));

        List<Integer> nums= Arrays.asList(5,8,10);
        assertThat(nums,everyItem(greaterThan(4)));
        assertThat(nums,everyItem(lessThan(16)));
        assertThat(nums,everyItem(lessThan(15)));



    }

}
