import "./Navbar.css";
import profileImg from "../assets/profile.png";
import { Link } from 'react-router-dom';  // Importă componenta Link

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
      <div className="container-fluid d-flex justify-content-between">
        <Link className="navbar-brand" to="#">
          <img src="" alt="navbar" />
        </Link>

        <div className="collapse navbar-collapse" id="navbarNavDropdown">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <Link className="nav-link active" aria-current="page" to="/">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/start-course">
                Start Course
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/features">
                Features
              </Link>
            </li>
            <li className="nav-item dropdown">
              <Link
                className="nav-link dropdown-toggle"
                to="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Dropdown link
              </Link>
              <ul className="dropdown-menu">
                <li>
                  <Link className="dropdown-item" to="/action">
                    Action
                  </Link>
                </li>
                <li>
                  <Link className="dropdown-item" to="/another-action">
                    Another action
                  </Link>
                </li>
                <li>
                  <Link className="dropdown-item" to="/something-else">
                    Something else here
                  </Link>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <div className="d-flex align-items-center">
          <div className="dropdown me-2">
            <Link
              className="nav-link dropdown-toggle d-flex align-items-center"
              to="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              <img
                src={profileImg}
                className="rounded-circle"
                alt="user profile"
                width="40"
                height="40"
              />
            </Link>
            <ul
              className="dropdown-menu dropdown-menu-end"
              aria-labelledby="navbarDropdown"
            >
              <li>
                <Link className="dropdown-item" to="/profile">
                  Profile
                </Link>
              </li>
              <li>
                <Link className="dropdown-item" to="/settings">
                  Settings
                </Link>
              </li>
              <li>
                <hr className="dropdown-divider" />
              </li>
              <li>
                <Link className="dropdown-item" to="/logout">
                  Logout
                </Link>
              </li>
            </ul>
          </div>

          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
