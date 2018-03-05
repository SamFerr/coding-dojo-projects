public class ProjectTest {
	public static void main(String[] args) {
        Project port = new Project();
        Project proj1 = new Project("Project 1", "Description 1");
        Project proj2 = new Project("Project 2", "Description 2");
        Project proj3 = new Project("Project 3", "Description 3");

        proj1.elevatorPitch();
        proj2.elevatorPitch();
        proj3.elevatorPitch();
    }
}