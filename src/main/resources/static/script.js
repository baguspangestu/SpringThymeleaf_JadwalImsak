const provinsiSelect = document.getElementById("provinsi");
provinsiSelect.addEventListener("change", onSelectProvinsi);
function onSelectProvinsi(event) {
  getDataKabKota(event.target.value);
}

async function getDataKabKota(provinsi) {
  try {
    const response = await fetch("https://equran.id/api/v2/imsakiyah/kabkota", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ provinsi }),
    });
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}
