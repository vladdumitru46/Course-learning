import { Link } from "react-router-dom";
import TilesInterface from "../../models/TilesInterface";


function Tiles({ name, description }: TilesInterface) {
  return (
    <div className="col-sm-6">
      <div className="card">
        <div className="card-body text-black"> 
          <h5 className="card-name">{name}</h5>
          <p className="card-text text-black">{description}</p>
          <Link to={`/course/${name}`} className="btn btn-primary">
            Start
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Tiles;
