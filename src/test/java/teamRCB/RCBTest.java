package teamRCB;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RCBTest {

	private int actualCountryCount;
	private int expectedCountryCount;
	private int actualRoleCount;
	private String countryName;
	private String roleName;
	JSONParser parser;
	Object object;
	JSONObject jsonObject;
	JSONArray jsonArray;

	@BeforeTest
	public void setup() {
		expectedCountryCount = 4;
		actualRoleCount = 0;
		countryName = "India";
		roleName = "Wicket-keeper";
		parser = new JSONParser();
		try {
			object = parser.parse(new FileReader("C:\\testfile.json"));
			jsonObject = (JSONObject)object;
			jsonArray = new JSONArray();
			jsonArray = (JSONArray) jsonObject.get("player");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateIfTeamHasOnlyFourForeignPlayers() {
		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject data =  (JSONObject) jsonArray.get(i);
			if(!data.get("country").equals(countryName)) {
				actualCountryCount++;
			}
		}
		Assert.assertEquals(actualCountryCount, expectedCountryCount, "The team does not have 4 foreign players");
	}

	@Test
	public void validateIfTeamHasAtLeastOneWicketkeeper() {

		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject data =  (JSONObject) jsonArray.get(i);
			if(data.get("role").equals(roleName)) {
				actualRoleCount++;
			}
		}
		Assert.assertTrue(actualRoleCount>=1, "There is no wicket keeper in the team");
	}
}