import { useState } from "react";
import Login from "./Login";
import Dashboard from "./Dashboard";
import Profile from "./Profile";

function App() {
  const [user, setUser] = useState(null);
  const [page, setPage] = useState("dashboard");

  const logout = () => {
    setUser(null);
  };

  if (!user) return <Login setUser={setUser} />;

  return (
    <div>
      {/* NAVBAR */}
      <div style={{ background: "#333", color: "#fff", padding: "10px" }}>
        <span style={{ marginRight: "20px" }}>🛒 MyStore</span>

        <button onClick={() => setPage("dashboard")}>Dashboard</button>
        <button onClick={() => setPage("profile")}>Profile</button>
        <button onClick={logout}>Logout</button>
      </div>

      {/* PAGES */}
      {page === "dashboard" && <Dashboard user={user} />}
      {page === "profile" && <Profile user={user} setUser={setUser} />}
    </div>
  );
}

export default App;
