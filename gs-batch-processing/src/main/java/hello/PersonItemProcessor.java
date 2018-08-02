package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;


public class PersonItemProcessor implements ItemProcessor<TimeWorked, TimeWorked> {

    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonItemProcessor.class);


    @Override
    public TimeWorked process(final TimeWorked timeWorked) throws Exception {
    	
    	LOGGER.info("CONTROL IS IN THE PROCESSOR");
        

      

        return timeWorked;
    }

}
