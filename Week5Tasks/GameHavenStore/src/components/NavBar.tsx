import { Heading, HStack, Image, Box, Switch, useColorMode, Spacer } from "@chakra-ui/react";
import StoreLogo from "../assets/StoreLogo.png";
import SideBar from "./SideBar";
import { useEffect, useState } from "react";
import DarkSwitch from "./DarkSwitch";

interface NavBarProps {
  setSelectedCategory: (category: string) => void;
  setCurrentPage: (page: number) => void;
}

function NavBar({ setSelectedCategory, setCurrentPage }: NavBarProps) {
  const [isScrolled, setIsScrolled] = useState(false);
  const { colorMode, toggleColorMode } = useColorMode(); // Dark Mode Toggle

  useEffect(() => {
    const handleScroll = () => {
      setIsScrolled(window.scrollY > 80);
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <Box
      as="nav"
      position="fixed"
      top="0"
      left="0"
      width="100%"
      height="70px"
      bg={isScrolled ? "gray.900" : "gray.800"}
      color="white"
      zIndex="1000"
      paddingX="20px"
      boxShadow={isScrolled ? "md" : "none"}
      transition="all 0.3s ease-in-out"
      display="flex"
      alignItems="center"
    >
      <HStack width="100%">
        {/* Left Side: Sidebar, Logo, and Site Name */}
        <SideBar setSelectedCategory={setSelectedCategory} setCurrentPage={setCurrentPage} />
        <Image src={StoreLogo} boxSize="60px" />
        <Heading size="lg" as="i">
          GameHaven
        </Heading>

        {/* Pushes DarkSwitch to the right */}
        <Spacer />

        {/* Right Side: Dark Mode Toggle */}
       <DarkSwitch></DarkSwitch>
      </HStack>
    </Box>
  );
}

export default NavBar;
