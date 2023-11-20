import React from "react";
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
} from "@nextui-org/react";
import { PiSmileySad } from "react-icons/pi";

interface RemoveItemModalProps {
  isOpen: boolean;
  onClose: () => void;
  removeCartItem: () => void;
}

const RemoveItemModal: React.FC<RemoveItemModalProps> = ({
  isOpen,
  onClose,
  removeCartItem,
}) => {
  return (
    <Modal
      hideCloseButton
      backdrop={"opaque"}
      classNames={{
        backdrop:
          "bg-gradient-to-t from-zinc-900 to-zinc-900/10 backdrop-opacity-20",
      }}
      isOpen={isOpen}
      onClose={onClose}
    >
      <ModalContent>
        <ModalHeader className="flex flex-col gap-1 text-black">
          Tem certeza que deseja remover este produto?
        </ModalHeader>
        <ModalBody className="flex flex-row justify-center p-8">
          <PiSmileySad className="h-20 w-20 text-gray-400" />
        </ModalBody>
        <ModalFooter>
          <Button
            color="danger"
            variant="light"
            onPress={() => {
              removeCartItem();
              onClose();
            }}
          >
            Remover
          </Button>
          <Button color="primary" onPress={onClose}>
            Cancelar
          </Button>
        </ModalFooter>
      </ModalContent>
    </Modal>
  );
};

export default RemoveItemModal;
