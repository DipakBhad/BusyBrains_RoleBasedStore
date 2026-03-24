import { useState } from "react";

function Profile({ user, setUser }) {
  const [username, setUsername] = useState(user.username);
  const [password, setPassword] = useState("");

  const updateProfile = async () => {
    const res = await fetch(`http://localhost:8080/user/${user.id}`, {
      method: "PUT",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({ username })
    });

    const data = await res.json();
    setUser(data);
    alert("Username updated");
  };

  const changePassword = async () => {
    await fetch(`http://localhost:8080/user/${user.id}/password`, {
      method: "PUT",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({ password })
    });

    alert("Password changed");
  };

  return (
    <div>
      <h2>Profile</h2>

      <p>Username: {user.username}</p>

      <input
        value={username}
        onChange={e => setUsername(e.target.value)}
      />
      <button onClick={updateProfile}>Update Username</button>

      <br /><br />

      <input
        placeholder="New Password"
        type="password"
        onChange={e => setPassword(e.target.value)}
      />
      <button onClick={changePassword}>Change Password</button>
    </div>
  );
}

export default Profile;