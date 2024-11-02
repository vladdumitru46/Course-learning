
import CodingChallange from "../../../models/ChallengesInterfaces";
import "./TheorySection.css";

interface TheorySectionProps {
  challenge: CodingChallange | null;
}

function TheorySection({ challenge }: TheorySectionProps) {
  return (
    <div className="theory">
      {challenge ? (
        <div className="challenge-section">
          <p><strong>Theory:</strong> {challenge.theory}</p>
        </div>
      ) : (
        <p>Select a challenge to view the theory.</p>
      )}
    </div>
  );
}

export default TheorySection;
