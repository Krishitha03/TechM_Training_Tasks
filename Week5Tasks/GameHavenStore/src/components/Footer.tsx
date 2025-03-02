import { Box, Container, Stack, Text, Link, IconButton, HStack } from "@chakra-ui/react";
import { FaTwitter, FaGithub, FaLinkedin } from "react-icons/fa";

const Footer = () => {
  return (
    <Box bg="gray.800" color="white" py={6} mt={8}>
      <Container maxW="container.lg">
        <Stack direction={["column", "row"]} justify="space-between" align="center">
          {/* Navigation Links */}
          <HStack spacing={6}>
            <Link href="/" _hover={{ textDecoration: "underline" }}>Home</Link>
            <Link href="/about" _hover={{ textDecoration: "underline" }}>About</Link>
            <Link href="/contact" _hover={{ textDecoration: "underline" }}>Contact</Link>
          </HStack>

          {/* Social Media Icons */}
          <HStack spacing={4}>
            <IconButton as="a" href="https://twitter.com" aria-label="Twitter" icon={<FaTwitter />} />
            <IconButton as="a" href="https://github.com" aria-label="GitHub" icon={<FaGithub />} />
            <IconButton as="a" href="https://linkedin.com" aria-label="LinkedIn" icon={<FaLinkedin />} />
          </HStack>
        </Stack>

        {/* Copyright */}
        <Text textAlign="center" mt={4} fontSize="sm">
          © {new Date().getFullYear()} Your Website Name. All rights reserved.
        </Text>
      </Container>
    </Box>
  );
};

export default Footer;
