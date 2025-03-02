import { Center, HStack, Switch, useColorMode } from "@chakra-ui/react";

function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack justifyContent={"Center"} display={"flex"}>
      <p>Theme Switch</p>
      <Switch
        colorScheme="orange"
        isChecked={colorMode == "dark"}
        onChange={toggleColorMode}
      >
        
      </Switch>
    </HStack>
  );
}
export default DarkSwitch;
