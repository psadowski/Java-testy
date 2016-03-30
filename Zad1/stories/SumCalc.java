import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.CandidateSteps;


public class SumCalc {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("AddCalc.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new AddSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}

}
