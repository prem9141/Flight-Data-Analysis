import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.IOException;

public class FlightOnSchedule
{
    public static void main(String[] args)throws Exception
    {
    	
        Job job = Job.getInstance();
	      
        job.setJarByClass(FlightOnSchedule.class);
        
        job.setMapperClass(FlightOnScheduleMapper.class);
        job.setReducerClass(FlightOnScheduleReducer.class);
        
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        
        job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
