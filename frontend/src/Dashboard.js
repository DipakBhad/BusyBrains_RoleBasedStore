import { useEffect, useState } from "react";

function Dashboard({ user }) {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");

  const loadProducts = () => {
    fetch("http://localhost:8080/products")
      .then(res => res.json())
      .then(setProducts);
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const addProduct = async () => {
    await fetch("http://localhost:8080/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Authorization": "Bearer " + localStorage.getItem("token")
      },
      body: JSON.stringify({ name, price })
    });

    setName("");
    setPrice("");
    loadProducts();
  };

  const deleteProduct = async (id) => {
    await fetch(`http://localhost:8080/products/${id}`, {
      method: "DELETE",
      headers: {
        "Authorization": "Bearer " + localStorage.getItem("token")
      }
    });

    loadProducts();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Welcome {user.username}</h2>

      {/* ADMIN PANEL */}
      {user.role === "ADMIN" && (
        <div style={{ marginBottom: "20px" }}>
          <h3>Add Product</h3>
          <input placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
          <input placeholder="Price" value={price} onChange={e => setPrice(e.target.value)} />
          <button onClick={addProduct}>Add</button>
        </div>
      )}

      <h3>Products</h3>

      {products.map(p => (
        <div key={p.id} style={{
          border: "1px solid #ccc",
          padding: "10px",
          margin: "10px",
          borderRadius: "5px"
        }}>
          <strong>{p.name}</strong> - ₹{p.price}

          {user.role === "ADMIN" && (
            <button onClick={() => deleteProduct(p.id)} style={{ marginLeft: "10px" }}>
              Delete
            </button>
          )}
        </div>
      ))}
    </div>
  );
}

export default Dashboard;

