import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

public class MinList {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("MinStory.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new MySteps());
		embedder.runStoriesAsPaths(storyPaths);
	}

}
