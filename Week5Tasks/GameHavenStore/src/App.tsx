import { Flex, Grid, GridItem, SimpleGrid } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import NavBar from "./components/NavBar";
import DarkSwitch from "./components/DarkSwitch";
import GameCard from "./components/GameCard";
import StorePagination from "./components/StorePagination";

const apiKey = "31d2ba27487d416f961ac7c451a09890";

function App() {
  const [games, setGames] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(""); // Category selection
  const [currentPage, setCurrentPage] = useState(1); // Pagination
  const pageSize = 10; // Games per page

  useEffect(() => {
    let url = `https://api.rawg.io/api/games?key=${apiKey}&page=${currentPage}&page_size=${pageSize}`;
    if (selectedCategory) {
      url += `&genres=${selectedCategory}`;
    }

    fetch(url)
      .then((res) => res.json())
      .then((data) => setGames(data.results || [])) // Handle possible empty results
      .catch((error) => console.error("Error fetching games:", error));
  }, [selectedCategory, currentPage]);

  return (
    <Grid templateAreas={`"nav" "main"`} gap={4}>
      <GridItem area={"nav"} display={"Flex"} justifyContent={"space-between"}>
        <NavBar setSelectedCategory={setSelectedCategory} setCurrentPage={setCurrentPage} />
        <DarkSwitch></DarkSwitch>
      </GridItem>

      <GridItem area={"main"} bg={"orange"} p={4}>
        <SimpleGrid columns={[1, 2, 3, 4]} spacing={3}>
          {games.length > 0 ? (
            games.map((game) => <GameCard key={game.id} game={game} />)
          ) : (
            <p>Loading...</p>
          )}
        </SimpleGrid>

        <StorePagination currentPage={currentPage} setCurrentPage={setCurrentPage} />
      </GridItem>
    </Grid>
  );
}

export default App;
