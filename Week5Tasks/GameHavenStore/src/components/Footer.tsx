import { Box, Container, Stack, Text, Link, IconButton, HStack } from "@chakra-ui/react";
import { FaTwitter, FaGithub, FaLinkedin } from "react-icons/fa";

const Footer = () => {
  return (
    <Box bg="gray.800" color="white" py={6} mt={8}>
      <Container maxW="container.lg">
        <Stack direction="column" align="center" spacing={4}>

          {/* Social Media Icons */}
          <HStack spacing={4}>
            <IconButton as="a" href="https://twitter.com" aria-label="Twitter" icon={<FaTwitter />} />
            <IconButton as="a" href="https://github.com" aria-label="GitHub" icon={<FaGithub />} />
            <IconButton as="a" href="https://linkedin.com" aria-label="LinkedIn" icon={<FaLinkedin />} />
          </HStack>

          {/* Copyright */}
          <Text textAlign="center" fontSize="sm">
            © {new Date().getFullYear()} GameHaven. All rights reserved.
          </Text>
          
        </Stack>
      </Container>
    </Box>
  );
};

export default Footer;
