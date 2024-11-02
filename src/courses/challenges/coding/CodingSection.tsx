
import Editor from "@monaco-editor/react";
import "./CodingSection.css";
import { useEffect, useState } from "react";
import CodingChallange from "../../../models/ChallengesInterfaces";

interface CodingSectionProps {
  challenge: CodingChallange | null;
}

function CodingSection({ challenge }: CodingSectionProps) {
  const [code, setCode] = useState(challenge?.task || "");

  useEffect(() => {
    if (challenge) {
      setCode(challenge.task); // Update code editor with selected challenge's task
    }
  }, [challenge]);

  const handleSubmit = () => {
    // Submit code logic here
  };

  return (
    <div className="coding-platform">
      {challenge ? (
        <>
          <Editor
            height="300px"
            defaultLanguage="python"
            value={code}
            theme="vs-dark"
            onChange={(value) => setCode(value || "")}
          />
          <button className="submit-button" onClick={handleSubmit}>Submit</button>
        </>
      ) : (
        <p>Select a challenge to start coding.</p>
      )}

      <div className="output-section">
        <h3>Output:</h3>
        <pre>{/* Display output here */}</pre>
      </div>
    </div>
  );
}

export default CodingSection;
