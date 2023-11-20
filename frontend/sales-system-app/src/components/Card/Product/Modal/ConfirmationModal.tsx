import React from "react";
import {
  Modal,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Button,
} from "@nextui-org/react";
import { BsFillCartCheckFill } from "react-icons/bs";
import Link from "next/link";

interface ConfirmationModalProps {
  isOpen: boolean;
  onClose: () => void;
}

const ConfirmationModal: React.FC<ConfirmationModalProps> = ({
  isOpen,
  onClose,
}) => {
  return (
    <Modal
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
          Produto adicionado ao Carrinho!
        </ModalHeader>
        <ModalBody className="flex flex-row justify-center p-8">
          <BsFillCartCheckFill className="h-20 w-20 text-gray-400" />
        </ModalBody>
        <ModalFooter>
          <Button color="primary" variant="bordered" onPress={onClose}>
            Continuar comprando
          </Button>
          <Button href="/cart" as={Link} color="primary" onPress={onClose}>
            Finalizar compra
          </Button>
        </ModalFooter>
      </ModalContent>
    </Modal>
  );
};

export default ConfirmationModal;
