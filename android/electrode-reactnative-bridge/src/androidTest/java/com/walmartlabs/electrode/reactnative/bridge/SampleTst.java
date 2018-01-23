package com.walmartlabs.electrode.reactnative.bridge;

import android.util.Log;

import com.walmartlabs.electrode.reactnative.sample.model.Address;
import com.walmartlabs.electrode.reactnative.sample.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by d0g00g4 on 1/22/18.
 */

public class SampleTst extends BaseBridgeTestCase {

    public void testMe() {
        List<Address> addressList = new ArrayList<Address>() {{
            add(new Address.Builder("1235 Walmart Ave", "94085").build());
            add(new Address.Builder("1233 SanBruno Ave", "94075").build());
        }};

        List<String> namesList = new ArrayList<String>() {{
            add("Name1");
            add("Name2");
        }};


        List<Integer> agesList = new ArrayList<Integer>() {{
            add(30);
            add(40);
        }};
        final Person inputPerson = new Person.Builder("testName", 10).addresses(addressList).siblingsNames(namesList).siblingsAges(agesList).build();

        Log.e("TEST###########", inputPerson.toString());
    }
}
