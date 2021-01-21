package batch;

import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dto.QnaDTO;
import service.QnAService;

public class SearchNoAnswerList implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		ArrayList<QnaDTO> list = null;
		list = QnAService.getInstance().selectNoAnswerList();
		System.out.println(list.toString());
	}

}











