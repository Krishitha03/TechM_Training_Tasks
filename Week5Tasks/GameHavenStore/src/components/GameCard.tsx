// import { Card, CardBody, Text, Image, SimpleGrid, Center } from "@chakra-ui/react";

// function GameCard() {
//   return (
//     <>
//       <SimpleGrid
//         spacing={6}
//         templateColumns="repeat(auto-fill, minmax(200px, 1fr))"
//       >
//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/oU5g_bYV0bMYEVjACWodJLD2CnRJ6KXPI-dz939XGrA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvZW4vdGh1bWIv/Ni82NS9BbmltYWxf/V2VsbF9Db3Zlcl9B/cnQuanBnLzIyMHB4/LUFuaW1hbF9XZWxs/X0NvdmVyX0FydC5q/cGc"></Image>
//             <Text textAlign="center">Animal well</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/4w-JEfIyaXr7mku2EwxV9SxgufXv_Ye37lcGv9JyU_c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9ob3ds/b25ndG9iZWF0LmNv/bS9nYW1lcy8yMTY4/Nl9HZXRfRXZlbi5q/cGc_d2lkdGg9NzYw"></Image>
//             <Text textAlign="center">Get Even</Text>
//           </CardBody>
//         </Card>
//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/2Lmu7x9U6o-gNb2D_RwwzD4Qr0vxBHjeKBzOhwj9UHY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMwLmdhbWVyYW50/aW1hZ2VzLmNvbS93/b3JkcHJlc3Mvd3At/Y29udGVudC91cGxv/YWRzLzIwMjQvMTIv/bWl4Y29sbGFnZS0w/NS1kZWMtMjAyNC0w/My0xNy1hbS0yNjEu/anBn"></Image>
//             <Text textAlign="center">Path of Exile 2</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/tDq28osWFF-Ce5GvavSF-Hqux9SA6x5JyNbu9voJhbA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvc2VhLW9mLXRo/aWV2ZXMtcGljdHVy/ZXMtZ2JyaDk2aDR4/OGJidGFiOC5qcGc"></Image>
//             <Text textAlign="center">Sea Of Theives</Text>
//           </CardBody>
//         </Card>

//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/pda0lyGxpQ7kwjcQfLdcUnhFmdwfynJN2kBvxaGeLlc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJjYXQuY29t/L3cvZnVsbC8yLzgv/NS8xMzA3OTItMjg4/MHgxODAwLWRlc2t0/b3AtaGQtZ3JhbmQt/dGhlZnQtYXV0by01/LWJhY2tncm91bmQt/aW1hZ2UuanBn"></Image>
//             <Text textAlign="center">Animal well</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/4w-JEfIyaXr7mku2EwxV9SxgufXv_Ye37lcGv9JyU_c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9ob3ds/b25ndG9iZWF0LmNv/bS9nYW1lcy8yMTY4/Nl9HZXRfRXZlbi5q/cGc_d2lkdGg9NzYw"></Image>
//             <Text textAlign="center">Get Even</Text>
//           </CardBody>
//         </Card>
//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/2Lmu7x9U6o-gNb2D_RwwzD4Qr0vxBHjeKBzOhwj9UHY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMwLmdhbWVyYW50/aW1hZ2VzLmNvbS93/b3JkcHJlc3Mvd3At/Y29udGVudC91cGxv/YWRzLzIwMjQvMTIv/bWl4Y29sbGFnZS0w/NS1kZWMtMjAyNC0w/My0xNy1hbS0yNjEu/anBn"></Image>
//             <Text textAlign="center">Path of Exile 2</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/tDq28osWFF-Ce5GvavSF-Hqux9SA6x5JyNbu9voJhbA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvc2VhLW9mLXRo/aWV2ZXMtcGljdHVy/ZXMtZ2JyaDk2aDR4/OGJidGFiOC5qcGc"></Image>
//             <Text textAlign="center">Sea Of Theives</Text>
//           </CardBody>
//         </Card>

//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/oU5g_bYV0bMYEVjACWodJLD2CnRJ6KXPI-dz939XGrA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvZW4vdGh1bWIv/Ni82NS9BbmltYWxf/V2VsbF9Db3Zlcl9B/cnQuanBnLzIyMHB4/LUFuaW1hbF9XZWxs/X0NvdmVyX0FydC5q/cGc"></Image>
//             <Text textAlign="center">Animal well</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/4w-JEfIyaXr7mku2EwxV9SxgufXv_Ye37lcGv9JyU_c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9ob3ds/b25ndG9iZWF0LmNv/bS9nYW1lcy8yMTY4/Nl9HZXRfRXZlbi5q/cGc_d2lkdGg9NzYw"></Image>
//             <Text textAlign="center">Get Even</Text>
//           </CardBody>
//         </Card>
//         <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/2Lmu7x9U6o-gNb2D_RwwzD4Qr0vxBHjeKBzOhwj9UHY/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMwLmdhbWVyYW50/aW1hZ2VzLmNvbS93/b3JkcHJlc3Mvd3At/Y29udGVudC91cGxv/YWRzLzIwMjQvMTIv/bWl4Y29sbGFnZS0w/NS1kZWMtMjAyNC0w/My0xNy1hbS0yNjEu/anBn"></Image>
//             <Text textAlign="center">Path of Exile 2</Text>
//           </CardBody>
//           </Card>
//           <Card>
//           <CardBody>
//             <Image src="https://imgs.search.brave.com/tDq28osWFF-Ce5GvavSF-Hqux9SA6x5JyNbu9voJhbA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93YWxs/cGFwZXJzLmNvbS9p/bWFnZXMvZmVhdHVy/ZWQvc2VhLW9mLXRo/aWV2ZXMtcGljdHVy/ZXMtZ2JyaDk2aDR4/OGJidGFiOC5qcGc"></Image>
//             <Text textAlign="center">Sea Of Theives</Text>
//           </CardBody>
//         </Card>
//       </SimpleGrid>
//     </>
//   );
// }
// export default GameCard;

import { Box, Card, CardBody, Image, SimpleGrid, Text } from "@chakra-ui/react";

function GameCard({ game }) {
  return (
    <SimpleGrid
      spacing={6}
      templateColumns="repeat(auto-fill, minmax(200px, 1fr))"
    >
      <Card>
          <CardBody>
          <Image
            src={game.background_image}
            alt={game.name}
            borderRadius="10px"
          />
          <Text fontSize="xl" fontWeight="bold" mt="2">
            {game.name}
          </Text>
          <Text fontSize="md" color="gray.500">
            Rating: {game.rating}
          </Text></CardBody>
      </Card>
    </SimpleGrid>
  );
}

export default GameCard;
