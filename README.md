# Project Description
This Project was developed as part of Course CS644 - Introduction to Big Data

# Final Project
In this project, you will develop an Oozie workflow to process and analyze a large volume of flight 
data.
Instructions:
1. Form a project team of four students (including yourself).
2. Install Hadoop/Oozie on your AWS VMs.
3. Download  the  Airline  On-time  Performance  data  set  (flight  data  set)  from  the  period  of 
October 1987 to April 2008 on the following website:
https://dataverse.harvard.edu/dataset.xhtml?persistentId=doi:10.7910/DVN/HG7NV7
4. Design, implement, and run an Oozie workflow to find out
a. the  3  airlines  with  the  highest  and  lowest  probability,  respectively,  for  being  on 
schedule;
b. the  3  airports  with  the  longest  and  shortest  average  taxi  time  per  flight  (both  in  and 
out), respectively; and
c. the most common reason for flight cancellations.
Requirements:
1. Your workflow must contain at least three MapReduce jobs that run in fully distributed mode.
2. Run your workflow to analyze the entire data set (total 22 years from 1987 to 2008) at one 
time on two VMs first and then gradually increase the system scale to the maximum allowed 
number of VMs for at least 5 increment steps, and measure each corresponding workflow 
execution time.
3. Run your workflow to analyze the data in a progressive manner with an increment of 1 year, 
i.e. the first year (1987), the first 2 years (1987-1988), the first 3 years (1987-1989), ..., and 
the total 22 years (1987-2008), on the maximum allowed number of VMs, and measure each 
corresponding workflow execution time.