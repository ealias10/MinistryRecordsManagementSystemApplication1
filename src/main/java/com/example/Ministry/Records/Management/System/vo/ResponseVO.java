package com.example.Ministry.Records.Management.System.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ResponseVO <T>{

    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private List<T> content;
    private long totalCount;
    public ResponseVO()
    {
        this.timestamp= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        this.status=200;
        this.message="sucess";
        this.content=new ArrayList<>();
    }
    public void addData(T content)
    {
        if(content!=null)
        {
            this.content.add(content);
        }
    }
    public void addDataList(List<T> content)
    {
        if(content!=null || !content.isEmpty())
        {
            this.content.addAll(content);
        }
    }
    public void paginationDataList(List<T> content,long totalCount)
    {
        if(content!=null || !content.isEmpty())
        {
            this.content.addAll(content);
            this.totalCount=totalCount;
        }
    }

}
