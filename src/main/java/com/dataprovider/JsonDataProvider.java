package com.dataprovider;


import com.helper.ResourceHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class JsonDataProvider {

    public static String testCaseName = "NA";

    @DataProvider(name = "TestData")
    public static Object[][] fetchData(Method method)  {
        return getData(method,"testdata");
    }

    @DataProvider(name = "TestDataCalculation")
    public static Object[][] fetchCalcData(Method method)  {
        return getData(method,"testdatacalc");
    }


    @DataProvider(name = "LeaseData")
    public static Object[][] fetchLeaseData(Method method) {
       return getData(method,"lease");
    }

    @DataProvider(name = "ApplicationData")
    public static Object[][] fetchApplicationData(Method method) {
        return getData(method,"application");
    }

    public static Object[][] getData(Method method,String fileName){
        Object result[][] = null;
        try{
            String dataFile =
                    ResourceHelper.getResourceHelper("/src/main/resources/testdata/"+fileName+".json");
            Object rowID, description;
            testCaseName = method.getName();
            JSONArray testData = (JSONArray) extractData_JSON(dataFile).get(method.getName());
            List<JSONObject> testDataList = new ArrayList<JSONObject>();
            for (int i = 0; i < testData.size(); i++) {
                testDataList.add((JSONObject) testData.get(i));
            }
            result = new Object[testDataList.size()][testDataList.get(0).size()];
            for (int i = 0; i < testDataList.size(); i++) {
                rowID = testDataList.get(i).get("rowID");
                description = testDataList.get(i).get("description");
                result[i] = new Object[]{rowID, description,
                        testDataList.get(i)};
            }
        }catch (Exception e){
            Assert.assertTrue(false,"Failed due to data fetch error"+e.getMessage());
        }
        return result;
    }



    /**
     * extractData_JSON - method to extract JSON data from a file
     *
     * @param file (including path)
     * @return JSONObject
     * @throws Exception
     */
    public static JSONObject extractData_JSON(String file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(reader);
    }

    /**
     * fetchData - method to get only the data that matches the filter
     *
     * @param file   (including path)
     * @param filter
     * @return JSONArray
     * @throws Exception
     */
    public static JSONArray fetchData(String file, String filter) throws Exception {

        JSONArray testData = (JSONArray) extractData_JSON(file).get(filter);

        return testData;
    }
}
