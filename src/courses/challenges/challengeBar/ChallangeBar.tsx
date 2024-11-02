import React, { useState } from "react";
import ChallengeDetailsValues from "../../../models/ChallengeDetails";
import "./ChallengeBar.css";

interface ChallangeBarProps {
  challangeNames: ChallengeDetailsValues; 
  onSelectChallenge: (challengeName: string, challengeType: string) => void;
}

function ChallangeBar({ challangeNames, onSelectChallenge }: ChallangeBarProps) {
  const [activeIndex, setActiveIndex] = useState<number | null>(null);

  const handleClick = (index: number, challengeName: string, challengeType: string) => {
    setActiveIndex(index);
    onSelectChallenge(challengeName, challengeType); 
  };

  return (
    <ul className="nav flex-column">
      {challangeNames.challenges.map((challenge, index) => (
        <li key={index} className="nav-item">
          <a
            className={`nav-link ${activeIndex === index ? "active" : ""}`}
            onClick={() => handleClick(index, challenge.name, challenge.task)}
            href="#"
          >
            {challenge.name}
          </a>
        </li>
      ))}
    </ul>
  );
}

export default ChallangeBar;
