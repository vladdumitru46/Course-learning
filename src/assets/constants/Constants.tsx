class Constants {
  private static baseUrl: string = "http://localhost:8080/";
  public static getCourseUrl: string = this.baseUrl + "course";
  public static getCourseDetailsUrl: string =
    this.baseUrl + "courseDetails?courseName=";
  public static logInUrl: string = this.baseUrl + "user/login";
  public static verifyToken: string =
    this.baseUrl + "userSession/verifyToken?token=";
  public static getChallengesForCourse: string =
    this.baseUrl + "courseChallenges/getAll?courseName=";
  public static getChallengeByName: string =
    this.baseUrl + "courseChallenges/getByName?name=";
  public static getChallengeTypeByName: string = this.baseUrl + "courseChallenges/getByChallengeTypeName?"
}

export default Constants;
