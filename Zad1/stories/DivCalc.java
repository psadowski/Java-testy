import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.CandidateSteps;


public class DivCalc {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("DivideCalc.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new DivideSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}

}
