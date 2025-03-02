import { HamburgerIcon } from "@chakra-ui/icons";
import {
  Box,
  Button,
  Card,
  CardBody,
  Drawer,
  DrawerBody,
  DrawerCloseButton,
  DrawerContent,
  DrawerHeader,
  DrawerOverlay,
  Heading,
  Stack,
  StackDivider,
  useDisclosure,
} from "@chakra-ui/react";
import React from "react";

interface SideBarProps {
  setSelectedCategory: (category: string) => void;
  setCurrentPage: (page: number) => void;
}

function SideBar({ setSelectedCategory, setCurrentPage }: SideBarProps) {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const handleCategoryClick = (category: string) => {
    setSelectedCategory(category);
    setCurrentPage(1); // Reset to first page on category change
    onClose();
  };

  return (
    <>
      <Button onClick={onOpen} m={4}>
        <HamburgerIcon />
      </Button>

      <Drawer onClose={onClose} isOpen={isOpen} size="xs" placement="left">
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton />
          <DrawerHeader>Menu</DrawerHeader>
          <DrawerBody>
            <Card>
              <CardBody>
                <Stack divider={<StackDivider />} spacing="4">
                  <Box onClick={() => handleCategoryClick("")} cursor="pointer">
                    <Heading size="xs" textTransform="uppercase">
                      Home (All Games)
                    </Heading>
                  </Box>
                  <Box onClick={() => handleCategoryClick("adventure")} cursor="pointer">
                    <Heading size="xs" textTransform="uppercase">
                      Adventure
                    </Heading>
                  </Box>
                  <Box onClick={() => handleCategoryClick("strategy")} cursor="pointer">
                    <Heading size="xs" textTransform="uppercase">
                      Strategy RPG
                    </Heading>
                  </Box>
                  <Box onClick={() => handleCategoryClick("puzzle")} cursor="pointer">
                    <Heading size="xs" textTransform="uppercase">
                      Puzzles
                    </Heading>
                  </Box>
                </Stack>
              </CardBody>
            </Card>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </>
  );
}

export default SideBar;
