document.addEventListener("DOMContentLoaded", async function () {
    const speakerContainer = document.querySelector(".speaker-container");

    try {
        const response = await fetch("speakers.json");
        const speakers = await response.json();

        speakerContainer.innerHTML = "";

        speakers.forEach((speaker) => {
            const speakerDiv = document.createElement("div");
            speakerDiv.classList.add("speaker");
            speakerDiv.innerHTML = `
                <img src="${speaker.image}" alt="${speaker.name}">
                <h3>${speaker.name}</h3>
            `;

            speakerDiv.addEventListener("click", () => {
                document.getElementById("modalTitle").textContent = speaker.name;
                document.getElementById("modalDescription").textContent = speaker.details;
                document.getElementById("speakerModal").style.display = "flex";
            });

            speakerContainer.appendChild(speakerDiv);
        });
    } catch (error) {
        console.error("Error loading speakers:", error);
    }
});

document.querySelector(".close").addEventListener("click", () => {
    document.getElementById("speakerModal").style.display = "none";
});

window.addEventListener("click", (event) => {
    if (event.target === document.getElementById("speakerModal")) {
        document.getElementById("speakerModal").style.display = "none";
    }
});

document.addEventListener("DOMContentLoaded", function () {
    const menuIcon = document.querySelector(".menu-icon");
    const navbar = document.querySelector(".navbar");

    if (menuIcon && navbar) {
        menuIcon.addEventListener("click", function () {
            navbar.classList.toggle("active");
        });
    }
});

