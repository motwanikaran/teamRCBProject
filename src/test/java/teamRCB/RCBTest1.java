package teamRCB;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;


public class RCBTest1   {
	public static void main(String[] args) throws IOException{
		Gson gson = new Gson();
		BufferedReader reader = new BufferedReader(new FileReader("C:\\testfile.json"));
		ArrayList<?> list = null;

		Map<?, ?> map = gson.fromJson(reader, Map.class);
		for (Map.Entry<?, ?> temp : map.entrySet()) {
			list = new ArrayList<String>();
			if(temp.getValue() instanceof List<?>) {
				list = (ArrayList<?>) temp.getValue();
			}
		}

		List<?> al=new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			al=Arrays.asList(list.get(i));
			JSONArray jArray = new JSONArray();
			jArray = (JSONArray) al;
			System.out.println(jArray.get(1));
		}
	}
}
 