import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class FlightCancellationReducer extends Reducer<Text, IntWritable, Text, Text> {
	private Map<String, Integer> map = new TreeMap<String, Integer>();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		Iterator<IntWritable> iter = values.iterator();
		Integer normal = 0;
		while (iter.hasNext()) {
			int ss = Integer.parseInt(iter.next().toString());
			normal = normal + ss;
		}
		map.put(key.toString(), normal);
	}

	@Override
	protected void cleanup(Context context) throws IOException, InterruptedException {

		if (!map.isEmpty()) {
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			Entry<String, Integer> entry = list.get(0);
			
			boolean flag = false;
			if("A".equals(entry.getKey())){
				flag =true;
				context.write(new Text("Cancellation due to Carrier"), new Text("Count is: "+entry.getValue() + ""));
			}
			else if("B".equals(entry.getKey())){
				flag =true;
				context.write(new Text("Cancellation due to Weather"), new Text("Count is: "+entry.getValue() + ""));
			}
			else if("C".equals(entry.getKey())){
				flag =true;
				context.write(new Text("Cancellation due to NAS"), new Text("Count is: "+entry.getValue() + ""));			
						}
			else if("D".equals(entry.getKey())){
				flag =true;
				context.write(new Text("Cancellation due to Security"), new Text("Count is: "+entry.getValue() + ""));
			}
			
			if(!flag){
				context.write(new Text("No Common Reason For Flight Cancellation"), new Text(""));
			}
			
		}else{
			context.write(new Text("No Common Reason For Flight Cancellation"), new Text(""));
		}
	}
}
