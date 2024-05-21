from __future__ import annotations
from dataclasses import dataclass, field
from kiota_abstractions.serialization import AdditionalDataHolder, Parsable, ParseNode, SerializationWriter
from typing import Any, Callable, Dict, List, Optional, TYPE_CHECKING, Union

if TYPE_CHECKING:
    from .person_occupation import Person_occupation

@dataclass
class Person(AdditionalDataHolder, Parsable):
    # Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
    additional_data: Dict[str, Any] = field(default_factory=dict)

    # The unique identifier of the person.
    id: Optional[int] = None
    # The name of the person.
    name: Optional[str] = None
    # The occupation of the person.
    occupation: Optional[Person_occupation] = None
    
    @staticmethod
    def create_from_discriminator_value(parse_node: Optional[ParseNode] = None) -> Person:
        """
        Creates a new instance of the appropriate class based on discriminator value
        param parse_node: The parse node to use to read the discriminator value and create the object
        Returns: Person
        """
        if not parse_node:
            raise TypeError("parse_node cannot be null.")
        return Person()
    
    def get_field_deserializers(self,) -> Dict[str, Callable[[ParseNode], None]]:
        """
        The deserialization information for the current model
        Returns: Dict[str, Callable[[ParseNode], None]]
        """
        from .person_occupation import Person_occupation

        from .person_occupation import Person_occupation

        fields: Dict[str, Callable[[Any], None]] = {
            "id": lambda n : setattr(self, 'id', n.get_int_value()),
            "name": lambda n : setattr(self, 'name', n.get_str_value()),
            "occupation": lambda n : setattr(self, 'occupation', n.get_enum_value(Person_occupation)),
        }
        return fields
    
    def serialize(self,writer: SerializationWriter) -> None:
        """
        Serializes information the current object
        param writer: Serialization writer to use to serialize this model
        Returns: None
        """
        if not writer:
            raise TypeError("writer cannot be null.")
        writer.write_int_value("id", self.id)
        writer.write_str_value("name", self.name)
        writer.write_enum_value("occupation", self.occupation)
        writer.write_additional_data_value(self.additional_data)
    

