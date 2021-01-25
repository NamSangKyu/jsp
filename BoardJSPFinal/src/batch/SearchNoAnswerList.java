package batch;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dto.QnaDTO;
import service.QnAService;

public class SearchNoAnswerList implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		List<QnaDTO> list = null;
		list = QnAService.getInstance().selectNoAnswerList();
		System.out.println(list.toString());
	}

}











