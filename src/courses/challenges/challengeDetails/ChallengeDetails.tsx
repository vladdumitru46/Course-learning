import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Constants from "../../../assets/constants/Constants";
import ChallangeBar from "../challengeBar/ChallangeBar";
import Navbar from "../../../navbar/Navbar";
import TheorySection from "../theorySection/TheorySection";
import CodingSection from "../coding/CodingSection";
import "./ChallengeDetails.css";
import ChallengeDetailsValues from "../../../models/ChallengeDetails";
import CodingChallange from "../../../models/ChallengesInterfaces";

function ChallengeDetails() {
  const { name } = useParams<{ name: string }>();
  const [challenge, setChallenge] = useState<CodingChallange | null>(null);
  const [challengeList, setChallengeList] = useState<ChallengeDetailsValues | undefined>(undefined); // Use ChallengeDetailsValues | undefined

  useEffect(() => {
    fetch(`${Constants.getChallengeByName}${name}`)
      .then((response) => response.json())
      .then((data: ChallengeDetailsValues) => {
        if (data && data.challenges) {
          setChallengeList(data); 
        }
      })
      .catch((error) => console.error("Error fetching challenges:", error));
  }, [name]);

  const handleSelectChallenge = (
    challengeName: string,
    challengeType: string
  ) => {
    fetch(
      `${Constants.getChallengeTypeByName}?challengeName=${challengeName}&challengeTypeName=${challengeType}`
    )
      .then((response) => response.json())
      .then((data: CodingChallange) => {
        setChallenge(data); 
      })
      .catch((error) => console.error("Error fetching challenge:", error));
  };

  return (
    <div className="challenge-page">
      <Navbar />
      <div className="content">
        {challengeList ? (
          <ChallangeBar challangeNames={challengeList} onSelectChallenge={handleSelectChallenge} />
        ) : (
          <p>Loading challenges...</p>
        )}

        <div className="main-content">
          <TheorySection challenge={challenge} />
          <CodingSection challenge={challenge} />
        </div>
      </div>
    </div>
  );
}

export default ChallengeDetails;
