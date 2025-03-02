import { Button, HStack } from "@chakra-ui/react";

interface StorePaginationProps {
  currentPage: number;
  setCurrentPage: (page: number) => void;
}

const StorePagination = ({ currentPage, setCurrentPage }: StorePaginationProps) => {
  return (
    <HStack mt={4} justifyContent="center">
      <Button colorScheme={"blackAlpha"} onClick={() => setCurrentPage(currentPage - 1)} isDisabled={currentPage === 1}>
        &laquo; Previous
      </Button>

      <Button  colorScheme={"blackAlpha"}>{currentPage}</Button>

      <Button  colorScheme={"blackAlpha"} onClick={() => setCurrentPage(currentPage + 1)}>
        Next &raquo;
      </Button>
    </HStack>
  );
};

export default StorePagination;
