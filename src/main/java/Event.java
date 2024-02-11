public class Event extends Task{

    protected String startTime;
    protected String endTime;

    public Event(){
        super(null);
    }

    public Event(String line){
        super(line);
        taskType = "E";
        int startDividerIndex = line.indexOf("/from");
        if(startDividerIndex == -1){
            setTaskName(line);
            setStartTime(null);
            setEndTime(null);
            return;
        }
        int endDividerIndex = line.indexOf("/to");
        if(endDividerIndex == startDividerIndex){
            String startTime = line.substring(startDividerIndex + 6);
            String taskName = line.substring(0, startDividerIndex - 1);
            setTaskName(taskName);
            setStartTime(startTime);
            setEndTime(null);
            return;
        }
        String startTime = line.substring(startDividerIndex + 6, endDividerIndex - 1);
        String endTime = line.substring(endDividerIndex + 4);
        String taskName = line.substring(0, startDividerIndex - 1);
        setStartTime(startTime);
        setEndTime(endTime);
        setTaskName(taskName);
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return String.format("[%s][%s] %s (from: %s to: %s)", taskType, doneSymbol, taskName, startTime, endTime);
    }

}
